import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StructureArrayExampleComponent } from './structure-array-example.component';

describe('StructureArrayExampleComponent', () => {
  let component: StructureArrayExampleComponent;
  let fixture: ComponentFixture<StructureArrayExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StructureArrayExampleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StructureArrayExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
