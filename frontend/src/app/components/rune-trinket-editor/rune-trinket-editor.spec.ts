import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuneTrinketEditor } from './rune-trinket-editor';

describe('RuneTrinketEditor', () => {
  let component: RuneTrinketEditor;
  let fixture: ComponentFixture<RuneTrinketEditor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuneTrinketEditor],
    }).compileComponents();

    fixture = TestBed.createComponent(RuneTrinketEditor);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
