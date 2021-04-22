import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeyyaComponent } from './heyya.component';

describe('HeyyaComponent', () => {
  let component: HeyyaComponent;
  let fixture: ComponentFixture<HeyyaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeyyaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeyyaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
